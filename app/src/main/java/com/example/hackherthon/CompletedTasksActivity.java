package com.example.hackherthon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class CompletedTasksActivity extends AppCompatActivity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_tasks);
    }
*/

    public class ScreenSlidePageFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return (ViewGroup) inflater.inflate(
                    R.layout.completed_task_fragment, container, false);
        }
    }

    public class ScreenSlidePagerActivity extends FragmentActivity {
        /**
         * The number of pages (wizard steps) to show in this demo.
         */
        private static final int NUM_PAGES = 3;

        /**
         * The pager widget, which handles animation and allows swiping horizontally to access previous
         * and next wizard steps.
         */
        private ViewPager2 viewPager;

        /**
         * The pager adapter, which provides the pages to the view pager widget.
         */
        private FragmentStateAdapter pagerAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.completed_tasks);

            // Instantiate a ViewPager2 and a PagerAdapter.
            viewPager = findViewById(R.id.pager);
            pagerAdapter = new ScreenSlidePagerAdapter(this);
            viewPager.setAdapter(pagerAdapter);
        }

        @Override
        public void onBackPressed() {
            if (viewPager.getCurrentItem() == 0) {
                // If the user is currently looking at the first step, allow the system to handle the
                // Back button. This calls finish() on this activity and pops the back stack.
                super.onBackPressed();
            } else {
                // Otherwise, select the previous step.
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        }

        /**
         * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
         * sequence.
         */
        private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
            public ScreenSlidePagerAdapter(FragmentActivity fa) {
                super(fa);
            }

            @Override
            public Fragment createFragment(int position) {
                return new ScreenSlidePageFragment();
            }

            @Override
            public int getItemCount() {
                return NUM_PAGES;
            }
        }
    }

}
