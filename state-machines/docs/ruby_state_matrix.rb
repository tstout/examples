 @state_matrix = {
        #Event          Offline Action/Next State      Online Action/Next State      Exception Action/Next State
        offline_evt:    [[:go_offline, nil],           [:go_offline,  OFFLINE_ST],   [:enable_ui, EXCEPTION_ST]],
        online_evt:     [[:go_online,  ONLINE_ST],     [nil,          nil],          [nil,        nil]],
        exception_evt:  [[:enable_ui,  EXCEPTION_ST],  [nil,          EXCEPTION_ST], [nil,        nil]]
    }
