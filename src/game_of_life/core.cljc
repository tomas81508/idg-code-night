(ns game-of-life.core
  (:require [ysera.test :refer [is= is is-not]]))

; A function declaration
; defn [name doc-string? attr-map? [params*] prepost-map? body]
;
; if [test then else?]
; (if (= 3 3) "That's true" "This will never happen") => "That's true"
;
; pos? [num]
; (pos? 5) => true
; (pos? -1) => false

(defn abs                                                   ; name
  "The absolute value of a number."                         ; doc-string?
  {:test (fn []
           (is= (abs 5) 5)
           (is= (abs -2) 2)
           (is= (abs 0) 0))}                                ; attr-map?
  [x]                                                       ; [params*]
  {:pre [(number? x)]}                                      ;  prepost-map?
  ; body
  ; write your implementation here
  0
  )


; Higher order functions
; map [f coll*]
;
; (map inc [1 3 7]) => [2 4 8]
;
; (map (fn [x] (inc x)) [1 3 7]) => [2 4 8]
;
; (map inc [1 3 7] [2 4 9]) => Wrong number of args (2) passed to inc
;
; (map + [1 3 7] [2 4 9]) => [3 7 16]
;
; (map (fn [x y] (+ x y)) [1 3 7] [2 4 9]) => [3 7 16]
;
;
; apply [f coll]
;
; (apply max [4 2 3 -1]) => 4
;
; (max 4 2 3 -1) => 4

;(defn distance
;  "Calculates the distance between two cells."
;  {:test (fn []
;           (is= (distance [0 0] [0 0]) 0)
;           (is= (distance [1 1] [3 1]) 2)
;           (is= (distance [1 1] [3 3]) 2)
;           (is= (distance [1 1] [1 3]) 2)
;           (is= (distance [4 3] [1 1]) 3))}
;  [cell-1 cell-2]
;
;  )
;
;(defn neighbours?
;  "Determines if cells are neighbours."
;  {:test (fn []
;           (is-not (neighbours? [0 0] [5 5]))
;           (is-not (neighbours? [0 0] [0 0]))
;           (is (neighbours? [0 0] [0 1])))}
;  [cell-1 cell-2]
;
;  )
;
;; To map with an index, use map-indexed [f coll]
;; then f is two variable function of index and item.
;
;(defn create-state
;  "Creates the state model for the game."
;  {:test (fn []
;           (is= (create-state " #  "
;                              "####"
;                              "  # ")
;                {:living-cells #{[1 0]
;                                 [0 1] [1 1] [2 1] [3 1]
;                                 [2 2]}}))}
;  [& strings]
;
;  )
;
;(defn neighbours-of
;  "Returns a set of all cells that are neighbours to the given cell."
;  {:test (fn []
;           (is= (neighbours-of [0 0])
;                #{[-1 -1] [0 -1] [1 -1] [-1 0] [1 0] [-1 1] [0 1] [1 1]})
;           (is= (neighbours-of [2 2])
;                #{[1 1] [2 1] [3 1] [1 2] [3 2] [1 3] [2 3] [3 3]}))}
;  [cell]
;
;  )
;
;(defn cell-alive?
;  "Determines if the given cell is alive."
;  {:test (fn []
;           (let [state (create-state "# ")]
;             (is (cell-alive? state [0 0]))
;             (is-not (cell-alive? state [1 0]))
;             (is-not (cell-alive? state [-1 -2]))))}
;  [state cell]
;
;  )
;
;(defn alive-neighbours-of
;  {:test (fn []
;           (is= (-> (create-state "##"
;                                  " #")
;                    (alive-neighbours-of [0 0]))
;                #{[1 0] [1 1]}))}
;  [state cell]
;  )
;
;; 1 Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
;; 2 Any live cell with two or three live neighbours lives on to the next generation.
;; 3 Any live cell with more than three live neighbours dies, as if by overpopulation.
;; 4 Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
;
;(defn next-generation
;  {:test (fn []
;           (let [state (create-state "##"
;                                     "##")]
;             (is= (next-generation state)
;                  state))
;           (is= (-> (create-state "   "
;                                  "###"
;                                  "   ")
;                    (next-generation))
;                (create-state " # "
;                              " # "
;                              " # ")))}
;  [state]
;  )
;
;(defn toggle-cell
;  {:test (fn []
;           (is (-> (create-state "")
;                   (toggle-cell [0 0])
;                   (cell-alive? [0 0])))
;           (is-not (-> (create-state "#")
;                       (toggle-cell [0 0])
;                       (cell-alive? [0 0]))))}
;  [state cell]
;  )
