package me.tokyojack.mcmarket.uhc.utils;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers.EndingCountdown;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers.GraceCountdown;
import me.tokyojack.mcmarket.uhc.utils.Kountdown.CountdownTimers.StartingCountdown;

public enum Countdown {
	STARTING {
		@Override
		public void start() {
			Countdown.startingCountdown.start();
		}

		@Override
		public void stop() {
			Countdown.startingCountdown.stop();
		}
	},
	ENDING {
		@Override
		public void start() {
			Countdown.endingCountdown.start();
		}

		@Override
		public void stop() {
			Countdown.endingCountdown.stop();
		}
	},
	GRACE {
		@Override
		public void start() {
			Countdown.graceCountdown.start();
		}

		@Override
		public void stop() {
			Countdown.graceCountdown.stop();
		}

	};

	public static EndingCountdown endingCountdown = new EndingCountdown(15, UHC.getPlugin());
	public static GraceCountdown graceCountdown = new GraceCountdown(5, UHC.getPlugin());
	public static StartingCountdown startingCountdown = new StartingCountdown(15, UHC.getPlugin());

	public void start() {
		// Should never be executed
	}

	public void stop() {
		// Should never be executed
	}
}
