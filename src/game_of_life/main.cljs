(ns game-of-life.main
  (:require [reagent.core :refer [render-component]]
            [game-of-life.core :refer [create-state
                                       next-generation
                                       toggle-cell]]
            [game-of-life.component.app :refer [app-component]]))

(enable-console-print!)

(def initial-state (create-state ""
                                 "###  "
                                 "  ###"
                                 " ### "
                                 "  #  "))

(defonce app-state-atom (atom (list initial-state)))

(defn handle-event [{name :name data :data}]
  (cond (= name :next-generation)
        (swap! app-state-atom (fn [state]
                                (conj state (next-generation (first state)))))

        (= name :cell-click)
        (swap! app-state-atom toggle-cell data)

        (= name :prev-generation)
        (when (> (count @app-state-atom) 1)
          (swap! app-state-atom (fn [atom] (drop 1 atom))))))

(defn render! []
  (render-component [app-component {:state         (first @app-state-atom)
                                    :trigger-event handle-event}]
                    (. js/document (getElementById "app"))))

(add-watch app-state-atom
           :main-watch
           (fn [_ _ old-state new-state]
             (when (not= old-state new-state)
               (render!))))

(render!)