class AppState
  OFFLINE_ST   = 0
  ONLINE_ST    = 1
  EXCEPTION_ST = 2

  @state_matrix = {
      #Event          Offline Action/Next State      Online Action/Next State      Exception Action/Next State
      offline_evt:    [[:go_offline, nil],           [:go_offline,  OFFLINE_ST],   [:enable_ui, EXCEPTION_ST]],
      online_evt:     [[:go_online,  ONLINE_ST],     [nil,          nil],          [nil,        nil]],
      exception_evt:  [[:enable_ui,  EXCEPTION_ST],  [nil,          EXCEPTION_ST], [nil,        nil]]
  }

  def initialize(actions)
    @actions = actions
    @current_state = OFFLINE_ST
  end

  def self.state_matrix
    @state_matrix
  end

  def state_matrix
    self.class.state_matrix
  end

  def lookup(event_sym)
    state_matrix[event_sym][@current_state]
  end

  def process_event(event_sym)
    action = lookup(event_sym)[0]
    next_state = lookup(event_sym)[1]

    @actions.send(action) unless action.nil?
    @current_state = next_state unless next_state.nil?
  end
end
