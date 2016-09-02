(defn tax-total [xml-resp resp-type]
  (->> (parse-resp xml-resp)
       :content
       (filter #(= (:tag %) resp-type))
       first
       :content
       (filter #(= (:tag %) :TotalTax))
       first
       :content
       first))
