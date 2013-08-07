package com.github.segmentio.flush;

import java.util.LinkedList;
import java.util.List;

import com.github.segmentio.Analytics;
import com.github.segmentio.Client;
import com.github.segmentio.models.BasePayload;
import com.github.segmentio.models.Batch;
import com.google.appengine.api.taskqueue.DeferredTask;

public class SendDataTask implements DeferredTask {

	private static final long serialVersionUID = -6307734145884211192L;

	BasePayload payload;

	public SendDataTask(BasePayload payload) {
		this.payload = payload;
	}

	public void run() {
		Client client = Analytics.getDefaultClient();
		client.getStatistics().updateInserted(1);
		List<BasePayload> current = new LinkedList<BasePayload>();

		if (payload != null) {
			current.add(payload);

			client.getStatistics().updateQueued(1);
		}

		if (current.size() > 0) {

			Batch batch = client.getFactory().create(current);

			client.getStatistics().updateFlushAttempts(1);

			client.getRequester().send(batch);

			current = new LinkedList<BasePayload>();
		}

	}

}
