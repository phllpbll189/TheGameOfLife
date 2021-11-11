package com.example.project2;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/example/project2/LoadFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/example/project2/LoadFragment$Adapter;", "controlListener", "Lcom/example/project2/LoadCallback;", "getControlListener", "()Lcom/example/project2/LoadCallback;", "setControlListener", "(Lcom/example/project2/LoadCallback;)V", "gridRepo", "Lcom/example/project2/database/GridRepo;", "model", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/project2/database/SavedGrid;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "updateUI", "saves", "Adapter", "SaveViewHolder", "app_debug"})
public final class LoadFragment extends androidx.fragment.app.Fragment {
    private final com.example.project2.database.GridRepo gridRepo = null;
    private androidx.lifecycle.LiveData<java.util.List<com.example.project2.database.SavedGrid>> model;
    private com.example.project2.LoadFragment.Adapter adapter;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recycler;
    @org.jetbrains.annotations.Nullable()
    private com.example.project2.LoadCallback controlListener;
    
    public LoadFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecycler() {
        return null;
    }
    
    public final void setRecycler(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.project2.LoadCallback getControlListener() {
        return null;
    }
    
    public final void setControlListener(@org.jetbrains.annotations.Nullable()
    com.example.project2.LoadCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void updateUI(java.util.List<com.example.project2.database.SavedGrid> saves) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/project2/LoadFragment$SaveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cellView", "Landroid/view/View;", "(Lcom/example/project2/LoadFragment;Landroid/view/View;)V", "button", "name", "Landroid/widget/TextView;", "savedGrid", "Lcom/example/project2/database/SavedGrid;", "setup", "", "app_debug"})
    final class SaveViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.example.project2.database.SavedGrid savedGrid;
        private android.view.View button;
        private final android.widget.TextView name = null;
        
        public SaveViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View cellView) {
            super(null);
        }
        
        public final void setup(@org.jetbrains.annotations.NotNull()
        com.example.project2.database.SavedGrid savedGrid) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/example/project2/LoadFragment$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/project2/LoadFragment$SaveViewHolder;", "Lcom/example/project2/LoadFragment;", "model", "", "Lcom/example/project2/database/SavedGrid;", "(Lcom/example/project2/LoadFragment;Ljava/util/List;)V", "getModel", "()Ljava/util/List;", "setModel", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    final class Adapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.project2.LoadFragment.SaveViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private java.util.List<com.example.project2.database.SavedGrid> model;
        
        public Adapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.project2.database.SavedGrid> model) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.project2.database.SavedGrid> getModel() {
            return null;
        }
        
        public final void setModel(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.project2.database.SavedGrid> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.project2.LoadFragment.SaveViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.project2.LoadFragment.SaveViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
    }
}