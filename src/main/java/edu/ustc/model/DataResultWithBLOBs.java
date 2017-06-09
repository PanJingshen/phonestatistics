package edu.ustc.model;

public class DataResultWithBLOBs extends DataResult {
    private byte[] figure2d;

    private byte[] figureHit;

    private byte[] figureOrigin;

    public byte[] getFigure2d() {
        return figure2d;
    }

    public void setFigure2d(byte[] figure2d) {
        this.figure2d = figure2d;
    }

    public byte[] getFigureHit() {
        return figureHit;
    }

    public void setFigureHit(byte[] figureHit) {
        this.figureHit = figureHit;
    }

    public byte[] getFigureOrigin() {
        return figureOrigin;
    }

    public void setFigureOrigin(byte[] figureOrigin) {
        this.figureOrigin = figureOrigin;
    }
}