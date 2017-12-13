(ns game-of-life.main
  (:require [reagent.core :refer [render-component]]
            [game-of-life.component.app :refer [app-component]]))

(enable-console-print!)

;(def initial-state (create-state ""
;                                 "###  "
;                                 "  ###"
;                                 " ### "
;                                 "  #  "))

(defonce app-state (atom nil))

;(defn handle-event [{name :name data :data}]
;  (println "Received an event:" name data))

(defn render! []
  (render-component [app-component {:state @app-state}]
                    (. js/document (getElementById "app"))))

;(add-watch app-state
;           :main-watch
;           (fn [_ _ old-state new-state]
;             (when (not= old-state new-state)
;               (render!))))

(render!)