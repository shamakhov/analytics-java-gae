package com.github.segmentio.flush;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.segmentio.Constants;
import com.github.segmentio.models.BasePayload;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

public class Flusher {

	private static final Logger logger = LoggerFactory.getLogger(Constants.LOGGER);

	public Flusher() {
	}

	public void enqueue(BasePayload payload) {

		Queue queue = QueueFactory.getQueue("analytics");
		queue.add(TaskOptions.Builder.withPayload(new SendDataTask(payload)));
	}
}
