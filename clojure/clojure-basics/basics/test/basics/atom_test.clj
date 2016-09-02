(ns basics.atom-test
  (:require
   [basics.core :refer :all]
   [expectations :refer :all]))

;;
;; -- Atoms --
;; A clojure atom is a fundamental unit of data that can only
;; change via an atomic operation.
;;
;;
(def a1 (atom {}))

;;
;; start out empty...
;;
(expect 0 (count @a1))

;;
;; Add an item...swap! 
;;
(expect
 "Todd"
 (do
   (swap! a1 assoc :me "Todd")
   (:me @a1)))

;;
;; Add an item, then remove it...
;;
(expect
 0
 (count
  (do 
    (swap! a1 assoc :me "Todd")
    (swap! a1 dissoc :me))))


(run-all-tests)
