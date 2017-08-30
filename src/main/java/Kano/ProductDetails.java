package Kano;

public class ProductDetails
{
    private String _productDetail;
    private String _symbol;
    private double _price;
    private int _qty;

    public ProductDetails(String product, String symbol, double price, int qty)
    {
        _productDetail = product;
        _symbol = symbol;
        _price = price;
        _qty = qty;
    }


    public String GetProductDetail()
    {
        return _productDetail;
    }

    public String GetSymbol()
    {
        return _symbol;
    }

    public double GetPrice()
    {
        return _price;
    }

    public int GetQty()
    {
        return _qty;
    }
}