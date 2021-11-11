package com.example.project2;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002*+B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0004J\b\u0010%\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\"J\u0006\u0010\'\u001a\u00020\"J\f\u0010(\u001a\u00020\u0004*\u00020)H\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006,"}, d2 = {"Lcom/example/project2/GameGridFragment;", "Landroidx/fragment/app/Fragment;", "()V", "alive", "", "Ljava/lang/Integer;", "dead", "handler", "Landroid/os/Handler;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "runnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/example/project2/Square;", "getViewModel", "()Lcom/example/project2/Square;", "setViewModel", "(Lcom/example/project2/Square;)V", "getAliveColor", "getDeadColor", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setAliveColor", "", "color", "setDeadColor", "squareChecker", "startHandler", "stopHandler", "toInt", "", "CellViewHolder", "gridAdapter", "app_debug"})
public final class GameGridFragment extends androidx.fragment.app.Fragment {
    private java.lang.Integer alive;
    private java.lang.Integer dead;
    private android.os.Handler handler;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Volatile()
    private volatile androidx.recyclerview.widget.RecyclerView recycler;
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Volatile()
    private volatile com.example.project2.Square viewModel;
    private final java.lang.Runnable runnable = null;
    
    public GameGridFragment() {
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
    public final com.example.project2.Square getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.Nullable()
    com.example.project2.Square p0) {
    }
    
    public final void startHandler() {
    }
    
    public final void stopHandler() {
    }
    
    private final int toInt(boolean $this$toInt) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void squareChecker() {
    }
    
    public final void setAliveColor(int color) {
    }
    
    public final void setDeadColor(int color) {
    }
    
    public final int getAliveColor() {
        return 0;
    }
    
    public final int getDeadColor() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/example/project2/GameGridFragment$CellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cellView", "Landroid/view/View;", "(Lcom/example/project2/GameGridFragment;Landroid/view/View;)V", "animator", "Landroid/view/animation/AlphaAnimation;", "button", "position", "", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "color", "", "setup", "app_debug"})
    final class CellViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private java.lang.Integer position;
        private android.view.View button;
        private android.view.animation.AlphaAnimation animator;
        
        public CellViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View cellView) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getPosition() {
            return null;
        }
        
        public final void setPosition(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        private final void color() {
        }
        
        public final void setup(int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/example/project2/GameGridFragment$gridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/project2/GameGridFragment$CellViewHolder;", "Lcom/example/project2/GameGridFragment;", "viewModel", "Lcom/example/project2/Square;", "(Lcom/example/project2/GameGridFragment;Lcom/example/project2/Square;)V", "NUM_CELLS", "", "getNUM_CELLS", "()I", "getViewModel", "()Lcom/example/project2/Square;", "setViewModel", "(Lcom/example/project2/Square;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    final class gridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.project2.GameGridFragment.CellViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private com.example.project2.Square viewModel;
        private final int NUM_CELLS = 400;
        
        public gridAdapter(@org.jetbrains.annotations.NotNull()
        com.example.project2.Square viewModel) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.project2.Square getViewModel() {
            return null;
        }
        
        public final void setViewModel(@org.jetbrains.annotations.NotNull()
        com.example.project2.Square p0) {
        }
        
        public final int getNUM_CELLS() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.project2.GameGridFragment.CellViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.project2.GameGridFragment.CellViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
    }
}