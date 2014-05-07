class Sku
  constructor: (@name, @id, @dept, @price) ->
    
  toString: ->
    "#{@name}:#{@dept}:#{@id}"
    
  cost: (quantity) ->
    quantity * @price

        
