/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
import { SortedIntList } from './hidden/SortedIntListLibrary.js'
class DelegationSortedIntList {
  private totalAdded: number
  private list: any

  constructor() {
    this.list = new SortedIntList()
    this.totalAdded = 0
  }

  /**
   * 
   * @param num  The number to be added to the list
   * @returns  True if the number was added successfully
   */
  add(num: number): boolean {
    this.totalAdded++
    return this.list.add(num)
  }

  /**
   * 
   * @param list The list to be added to the list
   * @returns  True if the list was added successfully
   */
  addAll(list: any): boolean {
    let success = true

    for (let i = 0; i < list.size(); ++i) {
      success &&= this.add(list.get(i))
    }

    return success
  }

  /**
   * 
   * @returns The total number of elements added to the list
   */

  getTotalAdded(): number {
    return this.totalAdded
  }

}

export { DelegationSortedIntList }
