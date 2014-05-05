var sum,
  __slice = [].slice;

sum = function() {
  var arg, args, counter, _i, _len;
  args = 1 <= arguments.length ? __slice.call(arguments, 0) : [];
  counter = 0;
  for (_i = 0, _len = args.length; _i < _len; _i++) {
    arg = args[_i];
    counter += arg;
  }
  return counter;
};
