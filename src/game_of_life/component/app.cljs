(ns game-of-life.component.app)

(defn app-component [{state :state}]
  [:div
   [:h1 {:style {:text-align "center"}}
    "Game of life"]
   [:div "Here we would like a game!!!"]])