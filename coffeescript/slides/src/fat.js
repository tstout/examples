var goodbye, hello;

this.name = 'Bob';

hello = function() {
  return console.log("Hello " + this.name);
};

goodbye = (function(_this) {
  return function() {
    return console.log("Goodbye " + _this.name);
  };
})(this);
