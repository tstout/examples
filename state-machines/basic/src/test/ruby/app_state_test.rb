gem 'minitest'
require 'minitest/autorun'
require 'app_state'

class AppStateTest < MiniTest::Test

  def setup
  end

  def teardown
  end

  # Fake test
  def test_fail
    mock = MiniTest::Mock.new
    mock.expect(:go_offline, nil)
    appState = AppState.new(mock)
    appState.process_event(:offline_evt)
    assert mock.verify
  end
end