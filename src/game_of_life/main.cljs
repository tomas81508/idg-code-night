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

(defn handle-event! [{name :name data :data}]
  (println "Name" name data)
  (cond (= name :next-generation)
        (swap! app-state-atom (fn [app-state]
                                (conj app-state (next-generation (first app-state)))))

        (= name :cell-click)
        (swap! app-state-atom (fn [app-state]
                                (conj app-state (toggle-cell (first app-state) data))))

        (= name :prev-generation)
        (when (> (count @app-state-atom) 1)
          (swap! app-state-atom (fn [app-state] (drop 1 app-state))))))

(defn render! []
  (render-component [app-component {:state         (first @app-state-atom)
                                    :trigger-event handle-event!}]
                    (. js/document (getElementById "app"))))

(add-watch app-state-atom
           :main-watch
           (fn [_ _ old-state new-state]
             (when (not= old-state new-state)
               (render!))))

(render!)