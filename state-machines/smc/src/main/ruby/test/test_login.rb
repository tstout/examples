gem 'minitest'
require 'minitest/autorun'

class TestLogin < MiniTest::Test
  def setup
  end

  def teardown
  end

  def test_basic_assertions

    x = %i(a b c)
    assert_instance_of(Array, x)
    assert_equal(x[0], :a)
    assert_equal(x[1], :b)
    assert_equal(x[2], :c)
    refute_nil(x)
  end

end