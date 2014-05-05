
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





