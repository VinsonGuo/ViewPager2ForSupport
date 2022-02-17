package com.vinsonguo.viewpager2.widget;
import android.support.annotation.NonNull;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

/**
 * Allows for combining multiple {@link PageTransformer} objects.
 *
 * @see ViewPager2#setPageTransformer
 * @see MarginPageTransformer
 */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers = new ArrayList<>();

    /**
     * Adds a page transformer to the list.
     * <p>
     * Transformers will be executed in the order that they were added.
     */
    public void addTransformer(@NonNull ViewPager2.PageTransformer transformer) {
        mTransformers.add(transformer);
    }

    /** Removes a page transformer from the list. */
    public void removeTransformer(@NonNull ViewPager2.PageTransformer transformer) {
        mTransformers.remove(transformer);
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        for (ViewPager2.PageTransformer transformer : mTransformers) {
            transformer.transformPage(page, position);
        }
    }
}

