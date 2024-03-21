<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">KATA</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav mx-auto my-2 my-lg-2 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    
                </ul>
                <div class="nav-login">
                    <hr class="vertical-line">
                    <router-link to="/Cart_page">
                        <i class="bi bi-basket-fill nav-icon"></i>
                        <div class="num-cart" v-if="totalQuantity">
                            <span>{{ totalQuantity }}</span>
                        </div>
                    </router-link>
                </div>
            </div>
        </div>
    </nav>
</template>
<script setup>
    import { computed } from 'vue';
    import {useCartStore} from '../store/cart.js'
    import { useProductStore } from '../store/product';

    const cart_store = useCartStore()
    
    const productStore = useProductStore()

    const totalQuantity = computed(() => cart_store.totalQuantity)
</script>
<style>

</style>
