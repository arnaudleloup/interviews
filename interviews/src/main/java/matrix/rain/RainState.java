package matrix.rain;


public enum RainState {

	INITIALIZING {
		@Override
		public RainState add(RainState state) {
			return state;
		}
	},

	PACIFIC {
		@Override
		public RainState add(RainState state) {
			if (state == ATLANTIC || state == BOTH) {
				return BOTH;
			}
			return PACIFIC;
		}
	},

	ATLANTIC {
		@Override
		public RainState add(RainState state) {
			if (state == PACIFIC || state == BOTH) {
				return BOTH;
			}
			return ATLANTIC;
		}
	},

	BOTH {
		@Override
		public RainState add(RainState state) {
			return BOTH;
		}
	},

	NONE {
		@Override
		public RainState add(RainState state) {
			if (state != null) {
				return state;
			}
			return NONE;
		}
	};

	public abstract RainState add(RainState state);
}