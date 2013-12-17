  #
  # State Constants
  #
  OFFLINE_ST = 0
  ONLINE_ST = 1
  EXCEPTION_ST = 2

  def initialize(backgroundController)
    @states = {
        OFFLINE_ST => 'offline',
        ONLINE_ST => 'online',
        EXCEPTION_ST => 'exception'
    }

    @state_matrix = {
        #Event          Offline Action/Next State      Online Action/Next State      Exception Action/Next State
        offline_evt:    [[:go_offline, nil],           [:go_offline,  OFFLINE_ST],   [:enable_ui, EXCEPTION_ST]],
        online_evt:     [[:go_online,  ONLINE_ST],     [nil,          nil],          [nil,        nil]],
        exception_evt:  [[:enable_ui,  EXCEPTION_ST],  [nil,          EXCEPTION_ST], [nil,        nil]]
    }

    @backgroundController = backgroundController
    @current_state = OFFLINE_ST

  def current_state_name
    @states[@current_state]
  end

  def lookup(event_sym)
    @state_matrix[event_sym][@current_state]
  end

  def process_event(event_sym)
    TCS::Logger.info "SM event: #{event_sym} current state is #{current_state_name}"
    action = lookup(event_sym)[0]
    next_state = lookup(event_sym)[1]

    self.send(action) unless action.nil?
    @current_state = next_state unless next_state.nil?
  end
