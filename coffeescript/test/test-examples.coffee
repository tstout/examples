
#
# 
# nodeunit tests
#

exports.group =
#
# Var-arg functions are know as splats in coffeescript. Originally,
# the syntax was *x (as in Ruby) not x... The name splats is still
# used however.  
# 
  varArgFunc: (test) ->

    sum = (args...) ->
      counter = 0
      counter += arg for arg in args
      counter
                      
    test.equal(sum(1, 2, 3), 6)
    
    test.done()

  privateVar: (test) ->
        
    test.ok(true, "this assertion should fail")
    test.done()

  defaultArgs: (test) ->

   add = (x = 1, y = 2) ->
      x + y
      
   test.equal(add(), 3)
   test.equal(add(1, 1), 2)              
   test.done()  

  calcClass: (test) ->

    class Calculator
      constructor: ->
        @memory = 0

      add: (x, y) ->
        x + y

      subtract: (x, y) ->
        x - y

      multiply: (x, y) ->
        x * y

      divide: (x, y) ->
        x / y
                
    calc = new Calculator()
    test.equal(calc.add(1, 1), 2)
    test.equal(calc.subtract(1, 1), 0)
    test.equal(calc.multiply(1, -1), -1)
    test.equal(calc.divide(144, 12), 12)
    test.done()

  skuClassWithNamedArgs: (test) ->

    class Sku
      constructor: ({name, id, dept, price}) ->
        @name = name
        @id = id
        @dept = dept
        @price = price

      toString: ->
        "#{@name}:#{@dept}:#{id}"

      cost: (quantity) ->
        quantity * @price  
      

    s = new Sku(name: 'double dish', id: 1, dept: 'kitchen', price: 19.99)
    test.equal(s.cost(2), 19.99 * 2)
     
    test.done()

  skuClass: (test) ->
    class Sku
      constructor: (@name, @id, @dept, @price) ->

      toString: ->
        "#{@name}:#{@dept}:#{@id}"

      cost: (quantity) ->
        quantity * @price  

    s = new Sku('double dish', 1, 'kitchen', 19.99)
    test.equal(s.toString(), 'double dish:kitchen:1')
    test.equal(s.cost(2), 19.99 * 2)
    
    test.done()   



               
    



