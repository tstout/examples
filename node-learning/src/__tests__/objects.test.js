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

    expect({ ...foo, c: 3 }).toEqual({ a: 1, b: 2, c: 3 });
  });
});
