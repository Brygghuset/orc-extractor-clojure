(ns orc-extractor.orc-file-test
  (:require [clojure.test :refer :all]
            [orc-extractor.orc-file :as orc-file :refer :all]))

(deftest test-read-file
  (testing "orc-file.read-file"
    (testing "function callable"
     (is function? orc-file/read-file))))
