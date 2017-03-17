package org.alfonz.samples.alfonzadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import org.alfonz.samples.alfonzmvvm.BaseFragment;
import org.alfonz.samples.databinding.FragmentAdapterSamplePagerBinding;


public class AdapterSamplePagerFragment extends BaseFragment<AdapterSampleView, AdapterSampleViewModel, FragmentAdapterSamplePagerBinding> implements AdapterSampleView
{
	private MessagePagerAdapter mAdapter;


	public static AdapterSamplePagerFragment newInstance()
	{
		return new AdapterSamplePagerFragment();
	}


	@Nullable
	@Override
	public Class<AdapterSampleViewModel> getViewModelClass()
	{
		return AdapterSampleViewModel.class;
	}


	@Override
	public FragmentAdapterSamplePagerBinding inflateBindingLayout(LayoutInflater inflater)
	{
		return FragmentAdapterSamplePagerBinding.inflate(inflater);
	}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		setModelView(this);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setupAdapter();
	}


	@Override
	public void onItemClick(String message)
	{
		showToast(message);
	}


	@Override
	public boolean onItemLongClick(String message)
	{
		showSnackbar(message);
		return true;
	}


	private void setupAdapter()
	{
		if(mAdapter == null)
		{
			mAdapter = new MessagePagerAdapter(this, getViewModel());
			getBinding().fragmentAdapterSamplePager.setAdapter(mAdapter);
		}
	}
}
