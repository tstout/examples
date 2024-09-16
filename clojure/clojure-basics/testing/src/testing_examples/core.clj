(ns testing-examples.core
  (:require [clojure.test :refer [is]]))

(defn divisible?
  "Is n divisble by d?"
  {:test (fn []
           (is (divisible? 49 7))
           (is (not (divisible? 48 7)))
           (is (divisible? 5 0)))}
  [n d]
  (zero? (try
           (mod n d)
           (catch Exception _ 0))))

(comment
  (meta #'divisible?)
;;
  )



(meta #'divisible?)