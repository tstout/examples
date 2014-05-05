sum = (args...) ->
  counter = 0
  counter += arg for arg in args
  counter
