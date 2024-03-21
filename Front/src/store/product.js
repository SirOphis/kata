import { defineStore } from 'pinia';
import axios from 'axios'
import {ref, computed} from 'vue'

export const useProductStore = defineStore('useProductStore', () => {
    const getProducts = ref([])
    const list_Product = computed(() => getProducts.value)

    //
    const load_Products = computed(() => getProducts.value.length > 0)
    const fetch_products = async () => {
        await axios.get(`${import.meta.env.VITE_API}`)
        .then((response) => {
            getProducts.value = response.data
            console.log(getProducts.value)
        }).catch((err) => {
            console.log(err)
        })
    }
    
    return {getProducts, fetch_products, list_Product, load_Products}
})
