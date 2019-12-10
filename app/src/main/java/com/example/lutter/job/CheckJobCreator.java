package com.example.lutter.job;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class CheckJobCreator implements JobCreator {

	@Override
	@Nullable
	public Job create(@NonNull String tag) {
		switch (tag) {
			case CheckJob.TAG:
				return new CheckJob();
			default:
				return null;
		}
	}
}
