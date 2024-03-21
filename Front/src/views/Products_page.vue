<template>
  <div class="container">
    <div class="mt-5 d-flex flex-wrap justify-content-center align-items-center" style="gap: 10px;">
      <div class="" v-for="(product, index) in productList" :key="index" style="margin-right: 10px;">
        <div class="card card-category " style="width: 19rem; height: 30rem;" >
          <img :src="product.imageUrl" class="card-img-top p-4 img-products" alt="...">
          <div class="p-3">
            <p :class="{'multi-line': product.title.length > 20}">{{ product.title }}</p>
            <p class="card-text" id="product_price">Price: {{ product.price }}&euro;</p>
          </div>
          <div class="btn-center ">
            <router-link :to ="`/Product_detail/${product.id}`"  class="btn btn-dark m-1" style="width: 45%;" type="button">Details</router-link>
            <button class="btn btn-dark m-1" style="width: 45%;" type="button" @click="cartStore.add_cart(product.id, product.title, product.price)">Add to cart</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
  import { useProductStore } from '../store/product'
  import { computed } from 'vue'
  import { useCartStore } from '../store/cart';

  const cartStore = useCartStore()
  const productStore = useProductStore()
  const productList = computed(() => productStore.list_Product)
</script>

<style>
  .img-products{
    width: 100px;
    height: 290px;
  }
  .card-category{
    border: none !important;
    box-shadow: 1px 1px 4px #e0e0e0;
    transition: all 0.2s ease-in-out;
  }
  .card-category:hover{
    box-shadow: 7px 7px 18px #e0e0e0;
    transition: all 0.2s ease-in-out;
  }
  .btn-center{
    display: flex;
    justify-content: center;
    align-items: end;
  }
</style>
