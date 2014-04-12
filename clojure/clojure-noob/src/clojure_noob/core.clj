(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

(println "Cleanliness is next to godliness")

(println (clojure-version))



(defn train
  []
  (println "Choo choo!"))

(train)


(def x #{:a :b :c})

(class x)

(def y {:a :b :c})

(def failed-protagonist-names
  ["Larry Potter"
   "Doreen the Explorer"
   "The Incredible Bulk"])

(defn inc-make
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 12)

;
; Infinite sequence..this will blow the memory
;                                      
(iterate #(println %) failed-protagonist-names)

(first failed-protagonist-names)

;
; Basic Iteration
;
(doseq [x failed-protagonist-names] (println x))

(source doseq)








