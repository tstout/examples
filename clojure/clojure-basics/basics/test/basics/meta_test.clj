(ns basics.meta-test
  (:require [expectations :refer :all]))

;;
;; Meta, meta, everywhere...
;;

;;
;; Attach a map of metadata to a var..
;; Note that ^{} is sugar for (with-meta ...)
;;
(def blah
  (with-meta {:a 1} {:meta-key "meta-value"}))

(expect "meta-value"
        (:meta-key (meta blah)))


(def map-with-meta
  ^{:meta-key1 "some-str-value"}
  {:a 1 :b 2})

(expect "some-str-value"
        (:meta-key1 (meta map-with-meta)))

;;
;; Functions can have meta...
;; Note that #' is sugar for (var ...)
;;
(def ^{:fn-meta-key 1} fn-with-meta []
  ;; ...impl not relevant...
  )

(expect 1 (:fn-meta-key (meta #'fn-with-meta)))

;;
;; Metadata is not limited to data. It can be functions as well.
;; This example merely attaches a function that will return
;; its argument to the var fn-with-fn-meta.
;;
(def ^{:meta-fn (fn [_] _)} fn-with-fn-meta[]
  ;; ...impl not relevant ....
  )

(expect true
        (fn? (:meta-fn (meta #'fn-with-fn-meta))))

(expect 1
        ((:meta-fn (meta #'fn-with-fn-meta)) 1))


