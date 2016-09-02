(ns basics.async-test
  (:require [expectations :refer :all]
            [clojure.core.async
             :as async :refer [>! <! >!! <!! go chan dropping-buffer sliding-buffer]]))

;;
;; Channel Creation
;;
;(comment
;  (chan) ​                                            ;; unbuffered (length=0)​
;  (chan 10) ​                                         ;; buffered (length=10)​
;  (chan (dropping-buffer 10)) ​                       ;; drop new values when full​
;  (chan (sliding-buffer 10))) ​                       ;; drop old values when full​

(def test-chan (chan 10))

(defn go-print
  "Pull messages from a channel and print them"
  [c]
  (go
    (loop []
      (when-some [val (<! c)]
                 (println "Received a message:" val)
                 (recur)))))


(expect 1 1)
