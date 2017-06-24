package com.jiogarden.log;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.apache.log4j.Level;

public class Logger {

	static Logger logger;

	static {
		logger = new Logger();
	}

	private Logger() {
		// Single Instance
	}

	/**
	 * Single Instance of Logger Class
	 * 
	 * @return
	 */
	public static Logger getInstance() {
		return logger;
	}

	/**
	 * Designates finer-grained informational events than the DEBUG.
	 * 
	 * @param clz
	 * @param object
	 */
	public void trace(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.trace(Level.toLevel(Level.TRACE_INT), t);
		} else {
			log.trace(object);
		}
	}

	/**
	 * Designates fine-grained informational events that are most useful to
	 * debug an application.
	 * 
	 * @param clz
	 * @param object
	 */
	public void debug(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.debug(Level.toLevel(Level.DEBUG_INT), t);
		} else {
			log.debug(object);
		}
	}

	/**
	 * Designates informational messages that highlight the progress of the
	 * application at coarse-grained level.
	 * 
	 * @param clz
	 * @param object
	 */
	public void info(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.info(Level.toLevel(Level.INFO_INT), t);
		} else {
			log.info(object);
		}
	}

	/**
	 * All levels including custom levels.
	 * 
	 * @param clz
	 * @param object
	 */
	public void all(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.info(Level.toLevel(Level.ALL_INT), t);
		} else {
			log.info(object);
		}
	}

	/**
	 * The highest possible rank and is intended to turn off logging.
	 * 
	 * @param clz
	 * @param object
	 */
	public void off(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.info(Level.toLevel(Level.OFF_INT), t);
		} else {
			log.info(object);
		}
	}

	/**
	 * Designates potentially harmful situations.
	 * 
	 * @param clz
	 * @param object
	 */
	public void warn(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.warn(Level.toLevel(Level.WARN_INT), t);
		} else {
			log.warn(object);
		}
	}

	/**
	 * Designates error events that might still allow the application to
	 * continue running.
	 * 
	 * @param clz
	 * @param object
	 */
	public void error(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.error(Level.toLevel(Level.ERROR_INT), t);
		} else {
			log.error(object);
		}
	}

	/**
	 * Designates very severe error events that will presumably lead the
	 * application to abort.
	 * 
	 * @param clz
	 * @param object
	 */
	public void fatal(Class<?> clz, Object object) {
		Log log = LogFactoryUtil.getLog(clz);
		if (object instanceof Throwable) {
			Throwable t = (Throwable) object;
			log.fatal(Level.toLevel(Level.FATAL_INT), t);
		} else {
			log.fatal(object);
		}
	}
}
