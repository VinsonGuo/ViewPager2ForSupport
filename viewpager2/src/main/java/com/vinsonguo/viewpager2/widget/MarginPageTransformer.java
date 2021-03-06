package com.vinsonguo.viewpager2.widget;
import android.support.annotation.NonNull;
import android.support.annotation.Px;
import android.support.v4.util.Preconditions;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;


/**
 * Adds space between pages via the {@link ViewPager2.PageTransformer} API.
 * <p>
 * Internally relies on {@link View#setTranslationX} and {@link View#setTranslationY}.
 * <p>
 * Note: translations on pages are not reset when this adapter is changed for another one, so you
 * might want to set them manually to 0 when dynamically switching to another transformer, or
 * when switching ViewPager2 orientation.
 *
 * @see ViewPager2#setPageTransformer
 * @see CompositePageTransformer
 */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    /**
     * Creates a {@link MarginPageTransformer}.
     *
     * @param marginPx non-negative margin
     */
    public MarginPageTransformer(@Px int marginPx) {
        Preconditions.checkArgumentNonnegative(marginPx, "Margin must be non-negative");
        mMarginPx = marginPx;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        ViewPager2 viewPager = requireViewPager(page);

        float offset = mMarginPx * position;

        if (viewPager.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
            page.setTranslationX(viewPager.isRtl() ? -offset : offset);
        } else {
            page.setTranslationY(offset);
        }
    }

    private ViewPager2 requireViewPager(@NonNull View page) {
        ViewParent parent = page.getParent();
        ViewParent parentParent = parent.getParent();

        if (parent instanceof RecyclerView && parentParent instanceof ViewPager2) {
            return (ViewPager2) parentParent;
        }

        throw new IllegalStateException(
                "Expected the page view to be managed by a ViewPager2 instance.");
    }
}
