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

(defonce app-state-atom (atom initial-state))

(defn handle-event [{name :name data :data}]
  (cond (= name :next-generation)
        (swap! app-state-atom next-generation)

        (= name :cell-click)
        (swap! app-state-atom toggle-cell data)))

(defn render! []
  (render-component [app-component {:state @app-state-atom
                                    :trigger-event handle-event}]
                    (. js/document (getElementById "app"))))

(add-watch app-state-atom
           :main-watch
           (fn [_ _ old-state new-state]
             (when (not= old-state new-state)
               (render!))))

(render!)