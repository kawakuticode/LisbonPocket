package com.lisbonpocket.code.kawakuti.lisbonpocket;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by russeliusernestius on 29/12/16.
 */

public class ItemDecoration  extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

