package com.sofka.inventory.domain.buys.usecase;

import com.sofka.inventory.domain.buys.dtos.BuysSummary;
import com.sofka.inventory.domain.buys.entity.Buys;
import com.sofka.inventory.domain.buys.entity.PurchaseProduct;
import com.sofka.inventory.domain.buys.repository.BuysProvider;
import com.sofka.inventory.domain.product.entity.Product;
import com.sofka.inventory.domain.product.repository.ProductMutation;
import com.sofka.inventory.domain.product.repository.ProductProvider;
import com.sofka.inventory.domain.buys.repository.BuysMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuysUseCases {
    @Autowired
    private BuysMutation mutationsBuys;
    @Autowired
    private BuysProvider buysProvider;
    @Autowired
    private ProductProvider productProviderProducts;
    @Autowired
    private ProductMutation productMutationProducts;

    public List<Buys> GetAll(int pageNumber, int size){
        return buysProvider.GetAll(pageNumber, size);
    }

    public BuysSummary Save(Buys buys){

    List<Product> products = findProducts(buys.getProducts());
    List<Product> newProducts = new ArrayList<>();
    List<PurchaseProduct> newPurchaseProduct = new ArrayList<>();
    BuysSummary buysSummary = new BuysSummary();
    List<String> productsSuccess = new ArrayList<>();
    List<String> productsError = new ArrayList<>();

    for (PurchaseProduct productData : buys.getProducts()){
            for (Product product : products){
                if(productData.getIdProduct().equals(product.getId())){
                    int purchaseQuantity = productData.getQuantity();

                    if(purchaseQuantity <= product.getInInventory()
                            && purchaseQuantity <= product.getMax()
                            && purchaseQuantity >= product.getMin()){

                       product.setInInventory(product.getInInventory() - purchaseQuantity);
                       newPurchaseProduct.add(productData);
                        newProducts.add(product);
                        productsSuccess.add(productData.getIdProduct());
                        break;
                    }

                    productsError.add(productData.getIdProduct());
                }
            }
    }

    for (Product product : newProducts){
        productMutationProducts.Update(product);
    }

    buys.getProducts().clear();
    buys.setProducts(newPurchaseProduct);
        Buys buysResult = mutationsBuys.Save(buys);

        buysSummary.setId(buysResult.getId());
        buysSummary.setDate(buysResult.getDate());
        buysSummary.setIdType(buysResult.getIdType());
        buysSummary.setIdClient(buysResult.getIdClient());
        buysSummary.setClientName(buysResult.getClientName());
        buysSummary.setSuccessfulProducts(productsSuccess);
        buysSummary.setErrorProducts(productsError);

        return buysSummary;
    }



    private List<Product> findProducts(List<PurchaseProduct> productsData){
        List<String> productsId = new ArrayList<>();
        for (PurchaseProduct product : productsData){
            productsId.add(product.getIdProduct());
        }
        return productProviderProducts.GetAllByIds(productsId);

    }


}
