package matrix.rain;

public enum RainState {

	DEFAULT {
		@Override
		public RainState add(RainState state) {
			return state;
		}
	},

	ATLANTIC {
		@Override
		public RainState add(RainState state) {
			if (PACIFIC == state || BOTH == state) {
				return BOTH;
			}

			return ATLANTIC;
		}
	},

	PACIFIC {
		@Override
		public RainState add(RainState state) {
			if (ATLANTIC == state || BOTH == state) {
				return BOTH;
			}

			return PACIFIC;
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
	},

	VISITING {
		@Override
		public RainState add(RainState state) {
			return state;
		}
	};

	public abstract RainState add(RainState state);
}