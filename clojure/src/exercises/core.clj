(ns exercises.core
  (:gen-class))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn prompt
  [prompt_string]
  (printf "%s " prompt_string) (flush)
  (read-line))

(defn no_such_ex [ex]
  (printf "Exercise %s not found.%n" ex))

(defn ex1 []
  "Prompt for a name and print a greeting."
  (let [name (prompt "What's your name?")]
    (printf "Hello, %s%n" (read-line))))

(defn ex2 []
  "Prompt for an input string and count the characters"
  (let [input (prompt "What's the input string?")]
    (case input
      ("" nil) (println "Please enter a string.")
      (printf "%s has %s characters%n" input (count input)))))

(defn ex3 []
  "Prompt for a quotation and a speaker and output dialogue."
  (let [quotation (prompt "What's the quote?")
        speaker (prompt "Who said it?")]
    (printf (str speaker " says, \"" quotation "\"%n"))))

(defn ex4 []
  "Prompt for sentence parts to create a nonsensical story."
  (let [noun (prompt "Enter a noun: ")
        verb (prompt "Enter a verb: ")
        adjective (prompt "Enter an adjective: ")
        adverb (prompt "Enter an adverb: ")]
    (printf "Did you hear about the %s %s? You should have seen it %s down the hill, whistling %s%n" adjective noun verb adverb)))

(defn ex5 []
  "Prompt for some numbers and maths them."
  (let [x (parse-int (prompt "What's the first number?"))
        y (parse-int (prompt "What's the second number?"))
        template "%s %s %s = %s%n"
        operations {"+" +
                    "-" -
                    "*" *
                    "/" /}]
    (printf (clojure.string/join (for [[ops, opf] operations]
                                      (format template x ops y (opf x y)))))))

(defn -main
  "I don't do a whole lot ... yet."
  [ex & args]
  (case ex
    "1" (ex1)
    "2" (ex2)
    "3" (ex3)
    "4" (ex4)
    "5" (ex5)
    (no_such_ex ex)))
