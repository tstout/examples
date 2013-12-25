gem 'minitest'
require 'minitest/autorun'
require 'app_state'

class AppStateTest < MiniTest::Test

  def test_verify_actions_called
    mock = MiniTest::Mock.new

    [:go_offline, :go_online, :enable_ui]
      .each { |action| mock.expect(action, nil) }

    app_state = AppState.new(mock)

    [:online_evt, :offline_evt, :exception_evt]
      .each { |evt| app_state.process_event(evt) }

    assert mock.verify
  end
end