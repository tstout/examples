var Sku;

Sku = (function() {
  function Sku(name, id, dept, price) {
    this.name = name;
    this.id = id;
    this.dept = dept;
    this.price = price;
  }

  Sku.prototype.toString = function() {
    return "" + this.name + ":" + this.dept + ":" + this.id;
  };

  Sku.prototype.cost = function(quantity) {
    return quantity * this.price;
  };

  return Sku;

})();
