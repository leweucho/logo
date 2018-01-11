(ns logo.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn draw-triangle [current-step]
  "Draw a single triangle—white or accidently gold—at nth position
   on the canvas represented by current-step argument."
  (let [w (q/width)
        x (mod (* current-step) w)
        y (/ (* current-step) w)
        m (rand-int 4)
        alpha (- 40 (* 10 m))]

        ;; grey outline
        (q/stroke 80 80 80)
        ;; 'coin' toss fill color
        (if (> (rand-int 100) 80)
          (q/fill 255 253 225 alpha)
          (q/fill 255 255 255 alpha))

        (q/triangle (+ x (q/random (* m -8)     -3))
                    (+ y (q/random       3  (* m 8)))
                    (+ x (q/random (* m -4) (* m 4)))
                    (+ y (q/random (* m -8)     -3))
                    (+ x (q/random       3  (* m 8)))
                    (+ y (q/random       3  (* m 8))))))


(defn draw-canvas []
  "Cover the canvas with triangles."
  (let [step 33
        min-range (- 0 (q/width))
        max-range (/ (* (q/width) (q/height)) step)]

    (dorun
      (for [i (range min-range max-range)]
        (draw-triangle (* step i))))))


;; Quil's functions: setup, draw & defsketch
(defn setup []
  (q/background 255 255 255)
  (q/no-loop))


(defn draw []
  (dorun (repeatedly 6 draw-canvas))
  (q/save "logo/logo.png"))


(defn -main [& args]
  (q/defsketch logo
    :title "Lewe Ucho Logo"
    :size [500 500]
    :setup setup
    :draw draw
    :features [:keep-on-top]))
