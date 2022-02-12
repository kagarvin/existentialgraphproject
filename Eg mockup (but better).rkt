;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname |Eg mockup (but better)|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #t)))
(require 2htdp/image)

(define-struct unit (name integer subs))
;; Unit is (make-unit String Intiger ListOfUnit)
;; interp. A Premise with a letter, hash ID and a list of sub-premises

;; ListOfUnit is one of:
;;  - empty
;;  - (cons Unit ListOfUnit)
;; interp. a list of premeses

(define Z (make-unit "Z" 100 empty))
(define Y (make-unit "Y" 200 empty))
(define X (make-unit "X" 300 empty))
(define Q (make-unit "Q" 400 empty))
(define R (make-unit "R" 500 empty))
(define S (make-unit "S" 600 empty))
(define B (make-unit "B" 700 empty))
(define C (make-unit "C" 800 empty))

(define W (make-unit "W"
                     10
                     (list X Y Z)))

(define P (make-unit "P"
                     20
                     (list Q R S)))

(define A (make-unit "A"
                     0
                     (list P W B C)))


#;#;#;
(define (fn-for-kind k)
  (cond [(string=? k "University") (...)]
        [(string=? k "Faculty")    (...)]
        [(string=? k "Department") (...)]
        [(string=? k "Division")   (...)]))

(define (fn-for-unit u)
  (... (unit-name u)
       (fn-for-kind (unit-kind u))
       (fn-for-lou (unit-subs u))))

(define (fn-for-lou lou)
  (cond [(empty? lou) (...)]
        [else
         (... (fn-for-unit (first lou))
              (fn-for-lou (rest lou)))]))

;; Unit -> ListOfString
;; ListOfUnit -> ListOfString ???
;; produce names of all the units in a unit
(check-expect (all-names--lou empty) empty)
(check-expect (all-names--unit Z)
              (list "Z"))
(check-expect (all-names--unit W)
              (list "W"
                    "X"
                    "Y"
                    "Z"))
(check-expect (all-names--lou (list Q R S))
              (list "Q"
                    "R"
                    "S"))
(check-expect (all-names--unit A)
              (append (list "A")
                      (all-names--unit P)
                      (all-names--unit W)
                      (all-names--unit B)
                      (all-names--unit C)))

;(define (all-names--unit u) empty)
;(define (all-names--lou lou) empty)

(define (all-names--unit u)
  (cons (unit-name u)
        (all-names--lou (unit-subs u))))

(define (all-names--lou lou)
  (cond [(empty? lou) empty]
        [else
         (append (all-names--unit (first lou))
                 (all-names--lou (rest lou)))]))