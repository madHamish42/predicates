(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [elm]
    (if (and (pred1 elm)
             (pred2 elm))
      true
      false)))

(defn pred-or [pred1 pred2]
  (fn [elm]
    (if (or (pred1 elm)
            (pred2 elm))
      true
      false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (every? true? (map whitespace? string))))

(defn blank-better? [string]
  (or (not string) ;better than (empty? string) ???
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true?
          (map (fn [award] (has-award? book award))
               awards)))

(defn HAS-ALL-THE-AWARDS-BETTER? [book awards]
  (every? (fn [award] (has-award? book award))
          awards))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn some1 [pred a-seq]
  (filter pred a-seq))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [k] (= (mod n k) 0))]
    (not (some pred (range 2 n)))))


()
