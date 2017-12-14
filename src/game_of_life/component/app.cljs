(ns game-of-life.component.app
  (:require [game-of-life.core :refer [cell-alive?]]))

(defn app-component [{state         :state
                      trigger-event :trigger-event}]
  (println state)
  [:div
   [:h1 {:style {:text-align "center"}}
    "Game of life"]
   [:div
    (let [size 10]
      (map (fn [y]
             [:div {:key   y
                    :style {:display "flex"}}
              (map (fn [x]
                     [:div {:key   x
                            :on-click (fn []
                                        (trigger-event {:name :cell-click
                                                        :data [x y]}))
                            :style {:position         "relative"
                                    :display          "inline-block"
                                    :width            (str (/ 100 size) "%")
                                    :border           "1px solid white"
                                    :background-color "lightgray"
                                    :padding-bottom   (str (/ 100 size) "%")}}
                      [:div {:style {:position         "absolute"
                                     :background-color "tomato"
                                     :top              "12.5%"
                                     :left             "12.5%"
                                     :border-radius    "50%"
                                     :height           "75%"
                                     :width            "75%"
                                     :transition       "all 500ms ease"
                                     :transform        (if (cell-alive? state [x y])
                                                         "scale(1)"
                                                         "scale(0)")}}]])
                   (range size))])
           (range size)))]
   [:button {:on-click (fn []
                         (trigger-event {:name :next-generation}))}
    "NEXT"]])