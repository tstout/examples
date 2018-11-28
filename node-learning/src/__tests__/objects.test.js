const { ORDER } = require("../objects");

describe("Object Intrinsics", () => {
  it("keys can be extracted from an object", () => {
    expect(Object.keys(ORDER)).toEqual(["orderId", "date"]);
  });

  it("values can be extracted from an object", () => {
    expect(Object.values(ORDER)).toEqual(["8675309", "2018-11-25"]);
  });

  it("Objects can be merged", () => {
    const foo = { a: 1, b: 2 };
    const bar = { c: 3, d: 4 };

    expect(Object.assign({}, foo, bar)).toEqual({ d: 4, b: 2, c: 3, a: 1 });
  });

  it("Object literals can contain functions", () => {
    const foo = { sum: (a, b) => a + b };

    expect(foo.sum(3, 5)).toEqual(8);
  });

  it("Spread operator can be applied in object literals (alternative to Object.assign()", () => {
    const foo = { a: 1, b: 2 };

    //expect({ ...foo, c: 3 }).toEqual({ a: 1, b: 2, c: 3 });
  });

  it("Array-like access is supported", () => {
    const foo = { a: 1, b: 2 };

    // this can be useful for computed keys
    expect(foo["a"]).toEqual(1);
  });

  describe("Destructuring", () => {
    it("Assign a subset of an object to local variables", () => {
      const objectWithManyKeys = { a: 1, b: 2, c: 3, d: 4 };
      const { a, d } = objectWithManyKeys;

      expect(a).toEqual(1);
      expect(d).toEqual(4);
    });

    it("Assign local alias of object subset", () => {
      const objectWithManyKeys = { a: 1, b: 2, c: 3, d: 4 };
      const { a: new_a, b: new_b } = objectWithManyKeys;

      expect(new_a).toEqual(1);
      expect(new_b).toEqual(2);
    });
  });
});
